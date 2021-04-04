package dev.viskar.lib.dinput8;

import dev.viskar.lib.common.NativeString;
import dev.viskar.lib.dinput8.internal.NativeUtils;
import dev.viskar.lib.dinput8.natives.DeviceInstance;
import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * Information about a device. Returned on calls to {@link DirectInput8W#EnumDevices(int, EnumDevicesCallback)}.
 * <p>
 * A discovered device can be passed to {@link DirectInput8W#CreateDevice(DeviceInstanceWrapper)};
 */
public class DeviceInstanceWrapper extends DeviceInstance {

    static {
        NativeUtils.assertSame(CLinker.C_SHORT, layout().select(
                MemoryLayout.PathElement.groupElement("tszInstanceName"),
                MemoryLayout.PathElement.sequenceElement()));
        NativeUtils.assertSame(CLinker.C_SHORT, layout().select(
                MemoryLayout.PathElement.groupElement("tszProductName"),
                MemoryLayout.PathElement.sequenceElement()));
    }

    private NativeString instanceName;
    private NativeString productName;

    public DeviceInstanceWrapper(MemoryAddress instanceAddr) {
        super(instanceAddr);
    }

    public DeviceInstanceWrapper(MemorySegment instanceStruct) {
        super(instanceStruct);
    }

    public String getInstanceName() {
        if (instanceName == null) {
            instanceName = NativeString.wcharString(getTszInstanceName());
        }
        return instanceName.toString();
    }

    public String getProductName() {
        if (productName == null) {
            productName = NativeString.wcharString(getTszProductName());
        }
        return productName.toString();
    }

}
